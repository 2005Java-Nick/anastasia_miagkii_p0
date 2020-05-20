package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

import voter.Voter;

public class VoterDAOPostgres{
	
	private static Logger log = Logger.getRootLogger();
	private static final String REGISTER_VOTER_QUERY = "insert into voters (passport_number, voter_name, birth_date, vote) values (?, ?,?,?);";
	
	private static final String GET_VOTER_QUERY = "select * from voters where passport_number = ?";

	public void registerVoter(Voter v) {
		Connection conn = ConnectionFactory.getConnection();
		//conn.setSchema(schema);
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(REGISTER_VOTER_QUERY);
			stmt.setString(1, v.getPassportNumber());
			stmt.setString(2, v.getFullName());
			stmt.setString(3, v.getBirthDate());
			stmt.setString(4, v.getVote());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.warn("Could not register new voter into database!");
			//e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("Connection did not close!");
				//e.printStackTrace();
			}
		}
		
	}

	
	public void getAllData() {
		
		Connection conn = ConnectionFactory.getConnection();
			
            System.out.println("Connecting to Voters database...");
            Statement stmt = null;
			try {
				stmt = conn.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
            System.out.println("Reading voter records...");
            System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", "Passport Number","Voter Name", "Birthdate", "Vote");
            ResultSet resultSet = null;
            ResultSet resultSet2 = null;
            ResultSet resultSet3 = null;
			try {
				resultSet = stmt.executeQuery("SELECT * FROM voters");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	            try {
					while (resultSet.next()) {
					    System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", resultSet.getString("passport_number"), resultSet.getString("voter_name"), resultSet.getString("birth_date"), resultSet.getString("vote"));
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            try {
					resultSet2 = stmt.executeQuery("select nyc_votes ();");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		            try {
						while (resultSet2.next()) {			
						    System.out.println("\nVotes for NYC: " + resultSet2.getString("nyc_votes"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            try {
						resultSet3 = stmt.executeQuery("select la_votes ();");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			            try {
							while (resultSet3.next()) {
							    System.out.println("Votes for LA: " + resultSet3.getString("la_votes"));
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            
       
    }
	
	
	public void getVoterInformation(String passNum) {
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
			try {
				stmt = conn.prepareStatement(GET_VOTER_QUERY);
				stmt.setString(1, passNum);
			} catch (SQLException e) {
				System.out.println("Oops! Unable to find any information!");// TODO Auto-generated catch block
				log.warn("Passport number was not found in the database.");
				//e.printStackTrace();
			} finally {
				try {
					resultSet = stmt.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			try {
				while (resultSet.next()) {
					System.out.println("\n\n\n\n\n\n\n\n\n\t\t\t\t Hello, " + resultSet.getString("voter_name") + ". Here's your information! \n\n");
					System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", "Passport Number","Voter Name", "Birthdate", "Vote");
				    System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", resultSet.getString("passport_number"), resultSet.getString("voter_name"), resultSet.getString("birth_date"), resultSet.getString("vote"));
				}
				try {
					conn.close();
				} catch (SQLException e) {
					log.error("Connection did not close!");
					e.printStackTrace();
				}
			} catch (SQLException e) {
				log.error("Unable to retrieve data from database!");
		e.printStackTrace();
	}
	
		}	
	}

	}

