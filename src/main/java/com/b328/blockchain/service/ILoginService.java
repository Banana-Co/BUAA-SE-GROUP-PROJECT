package com.b328.blockchain.service;

import com.b328.blockchain.entity.Role;
import com.b328.blockchain.entity.User;

public interface ILoginService {
    User getUserByName(String user_name);

    Role getRoles(long role_id);
}
