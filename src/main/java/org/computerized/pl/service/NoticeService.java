package org.computerized.pl.service;

import org.computerized.pl.dao.NoticeDAO;
import org.computerized.pl.model.notice.NoticeListVO;
import org.computerized.pl.model.notice.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeDAO noticeDAO;

    public List<NoticeListVO> loadNoticeList() {
        return noticeDAO.loadNoticeList();
    }

    public NoticeVO loadNoticeById(Integer noticeId) {
        return noticeDAO.loadNoticeById(noticeId);
    }
}
