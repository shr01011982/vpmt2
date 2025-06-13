package com.stellants.usrmgmt.service;

import com.stellants.usrmgmt.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO assignRole(Long userId, Long roleId);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserDTO dto);
    void delete(Long id);
}
