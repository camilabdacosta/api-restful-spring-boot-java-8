package com.ibm.apirestful;

import com.ibm.apirestful.endities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository <Empresa, Long>{
Empresa findByCnpj(String cnpj);


}
