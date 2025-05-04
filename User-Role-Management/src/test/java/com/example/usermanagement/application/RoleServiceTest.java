package com.example.usermanagement.application;

import com.example.usermanagement.application.interfaces.RoleRepository;
import com.example.usermanagement.domain.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    private RoleService roleService;

    @BeforeEach
    void setUp() {
        roleService = new RoleService(roleRepository);
    }

    @Test
    void createRole_ShouldReturnRoleId() {
        // Arrange
        String roleName = "ADMIN";
        Role role = new Role(roleName);
        when(roleRepository.save(any(Role.class))).thenReturn(role);

        // Act
        UUID roleId = roleService.createRole(roleName);

        // Assert
        assertNotNull(roleId);
    }

    @Test
    void getRole_WhenRoleExists_ShouldReturnRole() {
        // Arrange
        UUID roleId = UUID.randomUUID();
        Role role = new Role("ADMIN");
        when(roleRepository.findById(roleId)).thenReturn(Optional.of(role));

        // Act
        Role result = roleService.getRole(roleId);

        // Assert
        assertNotNull(result);
        assertEquals("ADMIN", result.getRoleName());
    }

    @Test
    void getRole_WhenRoleDoesNotExist_ShouldThrowException() {
        // Arrange
        UUID roleId = UUID.randomUUID();
        when(roleRepository.findById(roleId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> roleService.getRole(roleId));
    }
}