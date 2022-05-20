package com.company.jsonparsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class jsonJackson {
    public static void main(String[] args) throws IOException {

        // reading and updating the contents of example.json
        final ObjectMapper objectmapper = new ObjectMapper();
        List<Account> account5 = Arrays.asList(objectmapper.readValue(Paths.get("example.json").toFile(), Account[].class));

        for (int i = 0; i < 2; i++) {
             Account temp = account5.get(i);
             temp.setBalance(temp.getBalance() + 100);
        }

        Account newAccount = new Account("Sangwon", 31111, 157.32);

        List<Account> accountArray = new ArrayList<>(account5);
        accountArray.add(newAccount);
        objectmapper.writeValue(new File("updatedAccounts.json"), accountArray);
    }
}
