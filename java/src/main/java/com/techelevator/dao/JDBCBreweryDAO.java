package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.BreweryNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCBreweryDAO implements BreweryDAO {

    private final JdbcTemplate jdbcTemplate;

    public JDBCBreweryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Brewery getBreweryById(int id) {
        String sql = "SELECT * " +
                " FROM brewery " +
                " WHERE user_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToBrewery(results);
        } else {
            throw new BreweryNotFoundException();
        }
    }

    public void createNewBrewery(int breweryId, int brewerId, String name,
                                 String phoneNumber, String emailAddress,
                                 String address, String history,
                                 String openHours, String image,
                                 String breweryType) {
        String sql = "INSERT INTO brewery ( brewery_id,brewer_id,name,phone_number,email_address,address,history,open_hours,image,brewery_type " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ;";
        jdbcTemplate.queryForRowSet(sql,breweryId, brewerId , name, phoneNumber, emailAddress, address, history, openHours, image, breweryType );
        
    }




        private Brewery mapRowToBrewery(SqlRowSet rs){
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





