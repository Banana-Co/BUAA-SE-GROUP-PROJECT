package com.b328.blockchain.mapper;


import com.b328.blockchain.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    @Select("select name from u_permission as a, u_role_permission as b,u_user_role as c where a.id = b.pid and b.rid = c.rid and c.rid = #{user_id} ")
    List<Permission> findPermissionByUid(long user_id);

}
