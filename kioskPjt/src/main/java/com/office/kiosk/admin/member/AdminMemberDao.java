package com.office.kiosk.admin.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.office.kiosk.franchisee.member.FranchiseeMemberDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class AdminMemberDao {

   @Autowired
   JdbcTemplate jdbcTemplate;

   public List<FranchiseeMemberDto> selectAllFranchiseeInfo() {
      log.info("selectAllFranchiseeInfo");
      
      String sql = "SELECT * FROM TBL_FC_MEMBER";
      
      List<FranchiseeMemberDto> franchiseeMemberDtos = new ArrayList<>();
      
      try {
         
         RowMapper<FranchiseeMemberDto> rowMapper =
               BeanPropertyRowMapper.newInstance(FranchiseeMemberDto.class);
         franchiseeMemberDtos = jdbcTemplate.query(sql, rowMapper);
         
      } catch (Exception e) {
         e.printStackTrace();
      
      }
      
      return franchiseeMemberDtos;
   }
   
   

}