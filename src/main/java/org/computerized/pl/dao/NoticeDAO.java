package org.computerized.pl.dao;

import org.apache.ibatis.session.SqlSession;
import org.computerized.pl.model.notice.NoticeListVO;
import org.computerized.pl.model.notice.NoticePostVO;
import org.computerized.pl.model.notice.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NoticeDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<NoticeListVO> loadNoticeList() {
        return sqlSession.selectList("notice.loadNoticeList");
    }

    public NoticeVO loadNoticeById(Integer noticeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("noticeId", noticeId);

        List<NoticeVO> noticeVOList = sqlSession.selectList("notice.loadNoticeById", param);

        if (noticeVOList.size() == 0)
            return new NoticeVO();

        return noticeVOList.get(0);
    }

    public void initAddNotice(NoticePostVO noticePostVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("title", noticePostVO.getTitle());
        param.put("contents", "temp");
        param.put("writer", noticePostVO.getWriter());

        sqlSession.insert("notice.initAddNotice", param);
        noticePostVO.setNoticeId((Integer) param.get("noticeId"));
    }

    public void ConfirmPostNotice(NoticePostVO noticePostVO) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("noticeId", noticePostVO.getNoticeId());
        param.put("title", noticePostVO.getTitle());
        param.put("contents", noticePostVO.getContents());

        sqlSession.update("notice.ConfirmPostNotice", param);
    }

    public void delNotice(NoticePostVO noticePostVO) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("noticeId", noticePostVO.getNoticeId());
        sqlSession.update("notice.delNotice", param);
    }

    public List<NoticeListVO> searchNotice(String searchKey) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("searchKey", "%" + searchKey + "%");
        return sqlSession.selectList("notice.loadNoticeList", param);
    }
}
