package Attestation.attestation01;

import Attestation.attestation01.model.User;
import Attestation.attestation01.repositories.UsersRepository;
import Attestation.attestation01.repositories.UsersRepositoryFileImpl;

public class App {
    public static void main(String[] args) {
        UsersRepository repo = new UsersRepositoryFileImpl();


        User u1 = new User("herring", "qwerty123", "qwerty123",
                "Андреев", "Егор", "Семенович", 18, true);
        repo.create(u1);



        System.out.println("Найден пользователь: " + repo.findById(u1.getId()));


        System.out.println("Все пользователи: " + repo.findAll());


        repo.update(u1);


        repo.deleteById(u1.getId());
    }
}

