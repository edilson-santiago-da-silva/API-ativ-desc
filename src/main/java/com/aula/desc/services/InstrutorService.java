package com.aula.desc.services;

import com.aula.desc.entities.Instrutor;
import com.aula.desc.repositores.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {
   
        @Autowired
        private InstrutorRepository repository;

        public List<Instrutor> findAll(){
            return repository.findAll();
        }

        public Instrutor findById(Integer id) {
            Optional<Instrutor> obj = repository.findById(id);
            return obj.get();
        }

        public Instrutor insert(Instrutor obj) {
            return repository.save(obj);
        }

        public void delete(Integer id) {
            repository.deleteById(id);
        }

        public Instrutor update(Integer id, Instrutor obj) {
            Instrutor entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        private void updateData(Instrutor entity, Instrutor obj) {

        }
}

