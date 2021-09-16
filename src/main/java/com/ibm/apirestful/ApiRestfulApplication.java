package com.ibm.apirestful;

import com.ibm.apirestful.endities.Empresa;
import com.ibm.apirestful.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApiRestfulApplication {


    //@Autowired
   // private ExemploServices exemploServices;


    public static void main(String[] args) {
        SpringApplication.run(ApiRestfulApplication.class, args);
    }
    private final EmpresaRepository empresaRepository;

    public ApiRestfulApplication(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

  @Bean
  public CommandLineRunner commandLineRunner1(){
        return args ->{
           this.exemploServices.testarServico();
       };
  }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            Empresa empresa = new Empresa();
            empresa.setRazaoSocial("Mila IT");
            empresa.setCnpj("786754245632");

            this.empresaRepository.save(empresa);

            List<Empresa> empresas = empresaRepository.findAll();
            empresas.forEach(System.out::println);

           Empresa empresaDb = empresaRepository.findOne(1L);
           System.out.println("Empresa por ID:"+ empresaDb);




            empresaDb.setRazaoSocial("Mila IT Web");
            this.empresaRepository.save(empresaDb);

            Empresa empresaCnpj = empresaRepository.findByCnpj("786754245632");
            System.out.println("Empresa por CNPJ:"+ empresaCnpj);

            this.empresaRepository.delete(1L);
            empresas = empresaRepository.findAll();
            System.out.println("Empresas:"+ empresas.size());


            String senhaEcoded = SenhaUtils.gerarBCrypt("123456");
            System.out.println("senhaEcoded = " + senhaEcoded);

            senhaEcoded = SenhaUtils.gerarBCrypt("123456");
            System.out.println("senhaEcoded = " + senhaEcoded);

            System.out.println("Senha Valida = " +  SenhaUtils.senhaValida("123456",senhaEcoded));
        };
    }

}
