package com.portalClientesPrimadera.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portalClientesPrimadera.exception.ResourceNotFoundException;
import com.portalClientesPrimadera.model.UsersEntity;
import com.portalClientesPrimadera.repository.UsersRepository;

@CrossOrigin(origins =  "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/Users")
    public List<UsersEntity> ListarUsers(){
        return usersRepository.findAll();
    }

    @PostMapping("/Users")
    public UsersEntity saveUsers(@RequestBody UsersEntity users){
        return usersRepository.save(users);
    }

    @GetMapping("/Users/{id}")
    public ResponseEntity<UsersEntity> listarUserPorId(@PathVariable Long id){
        UsersEntity users = usersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("El usuario con este ID no existe : " + id));
        return ResponseEntity.ok(users);
    }

    @PutMapping("/Users/{id}")
    public ResponseEntity<UsersEntity> actualizarUserPorId(@PathVariable Long id, @RequestBody UsersEntity usersRequest){
        UsersEntity users = usersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("El usuario con este ID no existe : " + id));
        users.setCP_username(usersRequest.getCP_username());
        users.setCP_Password(usersRequest.getCP_Password());
        users.setCP_name(usersRequest.getCP_name());
        users.setCP_email(usersRequest.getCP_email());
        users.setCust_account_id(usersRequest.getCust_account_id());
        users.setCust_name(usersRequest.getCust_name());
        users.setCP_rol_id(usersRequest.getCP_rol_id());
        users.setCP_estatus(usersRequest.getCP_estatus());
        users.setCP_cell_phone(usersRequest.getCP_cell_phone());
        users.setParty_id(usersRequest.getParty_id());

        UsersEntity userActualizado = usersRepository.save(users);
        return ResponseEntity.ok(userActualizado);

    }
}
