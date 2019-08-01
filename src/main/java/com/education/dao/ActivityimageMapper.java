package com.education.dao;

import com.education.bean.Activityimage;

public interface ActivityimageMapper {
    int deleteByPrimaryKey(Integer imageid);

    int insert(Activityimage record);

    int insertSelective(Activityimage record);

    Activityimage selectByPrimaryKey(Integer imageid);

    int updateByPrimaryKeySelective(Activityimage record);

    int updateByPrimaryKey(Activityimage record);
}