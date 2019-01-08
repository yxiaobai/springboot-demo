package com.spring.boot.springbootdemo.service.impl;

import com.spring.boot.springbootdemo.dto.EnumModelType;
import com.spring.boot.springbootdemo.dto.MenuTreeDto;
import com.spring.boot.springbootdemo.dto.requestDto.InsertUserDto;
import com.spring.boot.springbootdemo.dto.responseDto.LoginResponseDto;
import com.spring.boot.springbootdemo.mapper.UserMapper;
import com.spring.boot.springbootdemo.mapper.mbg.UserRoleFunctionMapper;
import com.spring.boot.springbootdemo.model.TUser;
import com.spring.boot.springbootdemo.model.TUserExample;
import com.spring.boot.springbootdemo.model.UserRoleFunction;
import com.spring.boot.springbootdemo.model.UserRoleFunctionExample;
import com.spring.boot.springbootdemo.service.UserService;
import com.spring.boot.springbootdemo.utils.ApiResult;
import com.spring.boot.springbootdemo.utils.MD5Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private static final Log logger = LogFactory.getLog(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleFunctionMapper userRoleFunctionMapper;

    @Override
    public ApiResult<TUser> getUserByID(Integer id) {
        ApiResult<TUser> result = ApiResult.makeSuccessResult();
        TUser user =  userMapper.selectByPrimaryKey(id);
        result.setData(user);
        return result;
    }

    @Override
    public ApiResult<List<TUser>> getUserList() {
        ApiResult<List<TUser>> result = ApiResult.makeSuccessResult();
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        List<TUser> userList = userMapper.selectByExample(example);
        result.setData(userList);
        return result;
    }

    @Override
    public ApiResult<Boolean> addUser(InsertUserDto dto) {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginIDEqualTo(dto.getLoginID());
        List<TUser> userList = userMapper.selectByExample(example);
        if (userList.size()>0){
            result.setMsg("该用户已存在，请重新输入!");
            result.setData(Boolean.FALSE);
        }else {
            try {
                TUser user = new TUser();
                user.setLoginID(dto.getLoginID());
                user.setPassWord(MD5Utils.GetMD5Code(dto.getPassWord()));
                user.setLastName(dto.getLastName());
                user.setAddress(dto.getAddress());
                user.setPhone(dto.getPhone());
                user.setSignPath(dto.getSignPath());
                user.setStatus(EnumModelType.keyong.getNum());
                user.setCreator(1);
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                user.setUpdateUser(1);
                int id = userMapper.insertSelective(user);
                result.setData(Boolean.TRUE);
            }catch (Exception e){
                result.setData(Boolean.FALSE);
                logger.error("addUser error.......",e);
            }
        }
        return result;
    }

    @Override
    public ApiResult<LoginResponseDto> selectUser(TUser user) {
        ApiResult<LoginResponseDto> result = ApiResult.makeSuccessResult();
        TUserExample examplee = new TUserExample();
        TUserExample.Criteria criteriaa = examplee.createCriteria();
        criteriaa.andLoginIDEqualTo(user.getLoginID());
        criteriaa.andPassWordEqualTo(MD5Utils.GetMD5Code(user.getPassWord()));
        List<TUser> loginUsers = userMapper.selectByExample(examplee);
        TUser loginUser = loginUsers.get(0);
        if (loginUser!=null){
            UserRoleFunctionExample example = new UserRoleFunctionExample();
            UserRoleFunctionExample.Criteria criteria = example.createCriteria();
            criteria.andLoginIDEqualTo(loginUser.getLoginID());
            List<UserRoleFunction> listUser = userRoleFunctionMapper.selectByExample(example);
            LoginResponseDto dto = null;
            if (listUser!=null){
                dto = new LoginResponseDto();
                dto.setId(loginUser.getId());
                dto.setLoginID(loginUser.getLoginID());
                dto.setLastName(listUser.get(0).getLastName());
                MenuTreeDto menuTreeDto = new MenuTreeDto();
                //需改动
                List<MenuTreeDto> menuTreeDtoList = menuTreeDto.initMenuTree(listUser);
                dto.setMenuTreeDtoList(menuTreeDtoList);
                dto.setOperRightMap(menuTreeDto.initRightOpMap(listUser));
                result.setData(dto);
            }
        }else {
                result.setMsg("账户已被禁用，请联系管理员");
        }
        return result;
    }

    @Override
    public ApiResult<Boolean> delUser(Integer id) {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
       try {
           userMapper.deleteByPrimaryKey(id);
           result.setData(Boolean.TRUE);
       }catch (Exception e){
           result.setData(Boolean.FALSE);
           logger.error("delUser error......",e);
       }
        return result;
    }

    @Override
    public ApiResult<Boolean> updateUser(TUser user) {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        try {
            TUser user1 = new TUser();
            user.setPhone(user.getPhone());
            user.setAddress(user.getAddress());
            user.setUpdateTime( new Date());
            TUserExample example = new TUserExample();
            TUserExample.Criteria criteria =example.createCriteria();
            criteria.andLoginIDEqualTo(user.getLoginID());
            criteria.andPassWordEqualTo(MD5Utils.GetMD5Code(user.getPassWord()));
            userMapper.updateByExampleSelective(user1,example);
            result.setData(Boolean.TRUE);
        }catch (Exception e){
            result.setData(Boolean.FALSE);
            logger.error("updareUser error.......",e);
        }
        return result;
    }
}
