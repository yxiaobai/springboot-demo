package com.spring.boot.springbootdemo.mapper.mbg;

import com.spring.boot.springbootdemo.model.UserRoleFunction;
import com.spring.boot.springbootdemo.model.UserRoleFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleFunctionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_role_function
     *
     * @mbg.generated
     */
    long countByExample(UserRoleFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_role_function
     *
     * @mbg.generated
     */
    int deleteByExample(UserRoleFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_role_function
     *
     * @mbg.generated
     */
    int insert(UserRoleFunction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_role_function
     *
     * @mbg.generated
     */
    int insertSelective(UserRoleFunction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_role_function
     *
     * @mbg.generated
     */
    List<UserRoleFunction> selectByExample(UserRoleFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_role_function
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserRoleFunction record, @Param("example") UserRoleFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_role_function
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserRoleFunction record, @Param("example") UserRoleFunctionExample example);
}