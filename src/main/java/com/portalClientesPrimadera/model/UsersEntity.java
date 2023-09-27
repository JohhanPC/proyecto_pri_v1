package com.portalClientesPrimadera.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Users",uniqueConstraints = @UniqueConstraint(columnNames = "CP_username"))
public class UsersEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CP_user_id;

    @Column(name = "CP_username", nullable = false, length = 30)
    private String CP_username;

    @Column(name = "CP_Password", nullable = false, length = 30)
    private String CP_Password;

    @Column(name = "CP_name", nullable = false, length = 30)
    private String CP_name;

    @Column(name = "CP_email", nullable = false, length = 30)
    private String CP_email;

    @Column(name = "cust_account_id", nullable = false, length = 10)
    private Integer cust_account_id;

    @Column(name = "cust_name", nullable = false, length = 30)
    private String cust_name;

    @Column(name = "CP_rol_id", nullable = false, length = 10)
    private Integer CP_rol_id;

    @Column(name = "CP_estatus", nullable = false, length = 30)
    private String CP_estatus;

    @Column(name = "CP_cell_phone", nullable = false, length = 10)
    private Integer CP_cell_phone;

    @Column(name = "party_id", nullable = false, length = 10)
    private Integer party_id;



}
