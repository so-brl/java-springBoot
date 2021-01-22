package com.IntroductionSpringBoot.IntroductionSpringBoot.dao;

import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Character;
import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Type;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDaolmpl implements CharacterDao {

    @Override
    public List<Character> findAll() {
        ArrayList<Character> characterList = new ArrayList();
        try {
            Connection con = JDBCConnection.getInstance();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * from personnages");

            while (rs.next()){
                Character character = new Character(rs.getInt(1), rs.getString(2), Type.valueOf(rs.getString(3)));
                characterList.add(character);

            }
        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return characterList;
    }

    @Override
    public Character findById(int id) {
        Character character = new Character();
        try {
            Connection con = JDBCConnection.getInstance();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * FROM `personnages` WHERE `id`= " + id);
            while (rs.next()){
                character.setId(rs.getInt("id"));
                character.setName(rs.getString("name"));
                character.setType(Type.valueOf(rs.getString("type")));
            }
        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(character);
        return character;
    }


    @Override
    public void save(Character character) {
        String name = character.getName();
        Type type = character.getType();
        try {
            Connection con = JDBCConnection.getInstance();
            Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO personnages(NAME,TYPE) " + "VALUES ('" + name + "','" + type + "')");

        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void updPersonnage(int id, Character updCharacter) {
        String name = updCharacter.getName();
        Type type = updCharacter.getType();
        System.out.println(updCharacter);
        try {
            Connection con = JDBCConnection.getInstance();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `personnages` SET `name`='" + name + "',`type`='" + type + "'  WHERE `id`= " + id);
        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }





    @Override
    public void delete(int id) {
        try {
            Connection con = JDBCConnection.getInstance();
            Statement stmt = con.createStatement();
          stmt.executeUpdate("DELETE FROM `personnages` WHERE `id`= " + id);
        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }


}
