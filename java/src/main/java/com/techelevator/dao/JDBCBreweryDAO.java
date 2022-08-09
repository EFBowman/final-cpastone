package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.BreweryNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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
    @Override
    public boolean createNewBrewery(Brewery brewery) {
        String sql = "INSERT INTO brewery (brewer_id,name,phone_number,email_address,address,history,open_hours,image,brewery_type) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING brewery_id;";
       // jdbcTemplate.queryForRowSet(sql, brewery.getBrewerId() , brewery.getName(), brewery.getPhoneNumber(), brewery.getEmailAddress(), brewery.getAddress(), brewery.getHistory(), brewery.getOpenHours(), brewery.getImage(), brewery.getBreweryType() );
        Integer newBreweryId;
        newBreweryId = jdbcTemplate.queryForObject(sql, Integer.class, brewery.getBrewerId() , brewery.getName(), brewery.getPhoneNumber(), brewery.getEmailAddress(), brewery.getAddress(), brewery.getHistory(), brewery.getOpenHours(), brewery.getImage(), brewery.getBreweryType());
        if(newBreweryId == null) {
            return false;
        }
        return true;
    }
    @Override
    public List<Brewery> getAllBreweries() {
            List<Brewery> breweries = new ArrayList<>();

            String sql = "SELECT * " +
                         "FROM brewery;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Brewery brewery = mapRowToBrewery(results);
                breweries.add(brewery);
            }
            return breweries;
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
    }





