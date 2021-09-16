package com.ibm.apirestful.controller;

import com.ibm.apirestful.endities.Empresa;
import com.ibm.apirestful.dtos.EmpresaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.apirestful.response.Response;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @PostMapping
    public ResponseEntity<EmpresaDTO> cadastrar(@RequestBody EmpresaDTO empresaDTO){
    BindingResult result){
            Response<Empresa> response = new Response<Empresa>();

            if(result.hasErros()) {
                result.getAllErros().forEach(error -> response.getErros().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
        }



   // @PostMapping
    //public ResponseEntity<EmpresaDTO> cadastrar(@RequestBody EmpresaDTO empresaDTO){
      //  empresaDTO.setId(1L);
       // return ResponseEntity.ok(empresaDTO);
    //}

    @PostMapping
    public ResponseEntity<Response<Empresa>> cadastrar(@RequestBody Empresa empresaDTO){
       Response<Empresa> response = new Response<Empresa>();
        empresaDTO.setId(1L);
        response.setData(empresaDTO);
        return ResponseEntity.ok(response);
    }
}
