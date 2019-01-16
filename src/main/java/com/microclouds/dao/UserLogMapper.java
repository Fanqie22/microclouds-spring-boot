package com.microclouds.dao;

import com.microclouds.pojo.UserLog;
import com.microclouds.pojo.UserLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    long countByExample(UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    int deleteByExample(UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    int insert(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    int insertSelective(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    List<UserLog> selectByExample(UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    UserLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    int updateByPrimaryKeySelective(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_log
     *
     * @mbg.generated Wed Jan 16 14:59:41 CST 2019
     */
    int updateByPrimaryKey(UserLog record);
}