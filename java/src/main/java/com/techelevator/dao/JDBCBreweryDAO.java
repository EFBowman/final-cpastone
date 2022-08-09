package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.Objects;

public class JDBCBreweryDAO implements BreweryDAO{

    private final JdbcTemplate jdbcTemplate;

    public JDBCBreweryDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    private Brewery mapRowToBrewery(SqlRowSet rs) {
        Brewery brewery = new Brewery();
        brewery.setBreweryId(rs.getInt("brewery_id"));
        brewery.setBrewerId(rs.getInt("brewer_id"));
        brewery.setName(rs.getString("name"));
        brewery.setPhoneNumber(rs.getString("phone_number"));
        brewery.setEmailAddress(rs.getString("email_address"));
        brewery.setAddress(rs.getString("address"));
        brewery.setHistory(rs.getString("history"));
        brewery.setOpenHours(rs.getString("open_hours"));
        brewery.setImage(rs.getString("image"));
        brewery.setBreweryType(rs.getString("brewery_type"));
        return brewery;
    }




//    private User mapRowToUser(SqlRowSet rs) {
//        User user = new User();
//        user.setId(rs.getInt("user_id"));
//        user.setUsername(rs.getString("username"));
//        user.setPassword(rs.getString("password_hash"));
//        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
//        user.setActivated(true);
//        return user;
//    }
}


