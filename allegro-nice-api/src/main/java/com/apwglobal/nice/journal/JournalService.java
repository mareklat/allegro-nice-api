package com.apwglobal.nice.journal;

import com.apwglobal.nice.conv.JournalConv;
import com.apwglobal.nice.domain.EventType;
import com.apwglobal.nice.domain.Journal;
import com.apwglobal.nice.exception.AllegroExecutor;
import com.apwglobal.nice.login.Credentials;
import com.apwglobal.nice.service.AbstractAllegroIterator;
import com.apwglobal.nice.service.AbstractService;
import com.apwglobal.nice.service.Configuration;
import pl.allegro.webapi.*;
import rx.Observable;

import java.util.List;
import java.util.stream.Collectors;

public class JournalService extends AbstractService {

    public JournalService(ServicePort allegro, Credentials cred, Configuration conf) {
        super(allegro, cred, conf);
    }

    public Observable<Journal> getJournal(String session, long startingPoint) {
        return Observable.from(() -> new JournalIterator(session, startingPoint));
    }

    private class JournalIterator extends AbstractAllegroIterator<Journal> {

        public JournalIterator(String session, long startingPoint) {
            super(session, startingPoint);
        }

        @Override
        protected List<Journal> doFetch() {
            DoGetSiteJournalRequest request = new DoGetSiteJournalRequest(session, startingPoint, EventType.USER.getType());
            return AllegroExecutor.execute(() -> allegro.doGetSiteJournal(request)).getSiteJournalArray().getItem()
                    .stream()
                    .map(JournalConv::convert)
                    .sorted((j1, j2) -> Long.valueOf(j1.getRowId()).compareTo(j2.getRowId()))
                    .collect(Collectors.toList());
        }

        @Override
        protected long getItemId(Journal journal) {
            return journal.getRowId();
        }
    }
}
