package com.solanaexchange.project.service;

import com.solanaexchange.project.entity.Users;
import com.solanaexchange.project.model.UserRequestModel;
import com.solanaexchange.project.model.UserResponseModel;

public interface LoginService {

    UserResponseModel save(UserRequestModel userRequestModel);
}
