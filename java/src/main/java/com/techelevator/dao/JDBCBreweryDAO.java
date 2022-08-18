package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.BreweryNotFoundException;
import com.techelevator.model.SearchDTO;
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
    public Brewery getBreweryByPhoneNumber(String phoneNumber) {
        String sql = "SELECT * " +
                "FROM brewery " +
                "WHERE phone_number = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, phoneNumber);
        if(results.next()) {
            return mapRowToBrewery(results);
        }
        throw new BreweryNotFoundException();
    }

    @Override
    public List<Brewery> getAllBreweries(){
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM brewery ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Brewery brewery = mapRowToBrewery(results);
                breweries.add(brewery);
            }
            return breweries;
        }

    @Override
    public Brewery getBreweryById(String id) {
        String sql = "SELECT * " +
                " FROM brewery " +
                " WHERE brewery_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToBrewery(results);
        } else {
            throw new BreweryNotFoundException();
        }
    }
    @Override
    public boolean createNewBrewery(Brewery brewery) {
        String sql = "INSERT INTO brewery (brewer_id,name,phone_number,url,street,city,state,history,open_hours,image,brewery_type) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?) RETURNING brewery_id;";

        int intBreweryId = jdbcTemplate.queryForObject(sql, Integer.class, brewery.getBrewerId() , brewery.getName(), brewery.getPhoneNumber(), brewery.getUrl(), brewery.getStreet(), brewery.getCity(),
                brewery.getState(), brewery.getHistory(), brewery.getOpenHours(), brewery.getImage(), brewery.getBreweryType());
        String strBreweryId = Integer.toString(intBreweryId);
        if(strBreweryId == null) {
            return false;
        }
        brewery.setBreweryId(strBreweryId);
        return true;
    }
    @Override
    public List<Brewery> getAllBreweriesBySearchParams(SearchDTO searchDTO) {
            List<Brewery> breweries = new ArrayList<>();
            SqlRowSet results;
            String sql = "SELECT * " +
                         "FROM brewery " +
                         "WHERE state = ? ";

            if(!searchDTO.getCity().equals("") && !searchDTO.getBreweryType().equals("")) {
                sql += "AND city = ? AND brewery_type = ?;";
                results = jdbcTemplate.queryForRowSet(sql, searchDTO.getState(), searchDTO.getCity(), searchDTO.getBreweryType());
            } else if(!searchDTO.getBreweryType().equals("")) {
                sql += "AND brewery_type = ?;";
                results = jdbcTemplate.queryForRowSet(sql, searchDTO.getState() , searchDTO.getBreweryType());
            } else if (!searchDTO.getCity().equals("")) {
                sql += "AND city = ?;";
                results = jdbcTemplate.queryForRowSet(sql, searchDTO.getState(), searchDTO.getCity());
            } else {
                results = jdbcTemplate.queryForRowSet(sql, searchDTO.getState());
            }
            while(results.next()) {
                Brewery brewery = mapRowToBrewery(results);
                breweries.add(brewery);
            }
            return breweries;
    }

    @Override
    public List<Brewery> getAllBreweriesByState(String stateName) {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM brewery " +
                "WHERE state = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateName);
        while(results.next()){
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public List<Brewery> getAllBreweriesByCity(String city) {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM brewery " +
                "WHERE city = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, city);
        while(results.next()){
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public List<Brewery> getAllBreweriesByName(String name) {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM brewery " +
                "WHERE name ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while(results.next()){
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public List<Brewery> getAllBreweriesByType(String type) {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM brewery " +
                "WHERE brewery_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
        while(results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }
    @Override
    public void updateBrewery(Brewery brewery, String id){
        String sql = "UPDATE brewery " +
                    "SET brewer_id = ?, name = ?, phone_number = ? " +
                    "url = ?, street = ?, city = ?, state = ?, history = ?, open_hours = ? " +
                    "image = ?, brewery_type = ? " +
                    "WHERE brewery_id = ?;";
        jdbcTemplate.update(sql, brewery.getBrewerId(), brewery.getName(),
                brewery.getPhoneNumber(), brewery.getUrl(), brewery.getStreet(), brewery.getCity(),
                brewery.getState(), brewery.getHistory(), brewery.getOpenHours(), brewery.getImage(),
                brewery.getBreweryType(), id);
    }


    @Override
    public String getBreweryNameByBeerId(int id) {
        String sql = "SELECT name FROM brewery " +
                "JOIN beer ON beer.brewery_id = brewery.brewery_id " +
                "WHERE beer_id = ?;";
        String name = jdbcTemplate.queryForObject(sql, String.class, id);
        return name;
    }


        private Brewery mapRowToBrewery(SqlRowSet rs){
            Brewery brewery = new Brewery();
            brewery.setBreweryId(rs.getString("brewery_id"));
            brewery.setBrewerId(rs.getInt("brewer_id"));
            brewery.setName(rs.getString("name"));
            brewery.setPhoneNumber(rs.getString("phone_number"));
            brewery.setUrl(rs.getString("url"));
            brewery.setStreet(rs.getString("street"));
            brewery.setCity(rs.getString("city"));
            brewery.setState(rs.getString("state"));
            brewery.setHistory(rs.getString("history"));
            brewery.setOpenHours(rs.getString("open_hours"));
            brewery.setImage(rs.getString("image"));
            brewery.setBreweryType(rs.getString("brewery_type"));
            return brewery;
        }
    }





