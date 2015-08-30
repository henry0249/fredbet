package de.fred4jupiter.fredbet.web.matches;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fred4jupiter.fredbet.domain.Group;

public class MatchCommand {

	private static final String TIME_FORMAT_PATTERN = "HH:mm";

	private static final String DATE_FORMAT_PATTERN = "dd. MMMM yyyy";

	private static final Logger LOG = LoggerFactory.getLogger(MatchCommand.class);

	private String matchId;

	private String teamNameOne;

	private String teamNameTwo;

	private Integer teamResultOne;

	private Integer teamResultTwo;

	private Group group;

	// format: yyyy-MM-dd
	private String kickOffDateString;

	private String kickOffTimeString;

	private String stadium;

	private Integer userBetGoalsTeamOne;

	private Integer userBetGoalsTeamTwo;

	private Integer points;

	public MatchCommand() {
		super();
	}

	public MatchCommand(String teamNameOne, String teamNameTwo, Integer teamResultOne, Integer teamResultTwo) {
		super();
		this.teamNameOne = teamNameOne;
		this.teamNameTwo = teamNameTwo;
		this.teamResultOne = teamResultOne;
		this.teamResultTwo = teamResultTwo;
	}

	private boolean hasResults() {
		return teamResultOne != null && teamResultTwo != null;
	}

	public boolean isBettable() {
		if (hasMatchStarted() || hasMatchFinished() || hasResults()) {
			return false;
		}

		return true;
	}

	public LocalDateTime getKickOffDate() {
		if (StringUtils.isBlank(kickOffDateString)) {
			return null;
		}
		LocalDate parsedDate = LocalDate.parse(this.kickOffDateString, DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
		LocalTime localTime = LocalTime.parse(this.kickOffTimeString, DateTimeFormatter.ofPattern(TIME_FORMAT_PATTERN));
		return LocalDateTime.of(parsedDate, localTime);
	}

	public void setKickOffDate(LocalDateTime kickOffDate) {
		this.kickOffDateString = kickOffDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
		this.kickOffTimeString = kickOffDate.format(DateTimeFormatter.ofPattern(TIME_FORMAT_PATTERN));
	}

	public String getKickOffDateFormatted() {
		return DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN).format(getKickOffDate());
	}

	private boolean hasMatchStarted() {
		return LocalDateTime.now().isAfter(getKickOffDate());
	}

	public boolean hasMatchFinished() {
		return teamResultOne != null && teamResultTwo != null;
	}

	public String getTeamNameOne() {
		return teamNameOne;
	}

	public void setTeamNameOne(String teamNameOne) {
		this.teamNameOne = teamNameOne;
	}

	public String getTeamNameTwo() {
		return teamNameTwo;
	}

	public void setTeamNameTwo(String teamNameTwo) {
		this.teamNameTwo = teamNameTwo;
	}

	public Integer getTeamResultOne() {
		return teamResultOne;
	}

	public void setTeamResultOne(Integer teamResultOne) {
		this.teamResultOne = teamResultOne;
	}

	public Integer getTeamResultTwo() {
		return teamResultTwo;
	}

	public void setTeamResultTwo(Integer teamResultTwo) {
		this.teamResultTwo = teamResultTwo;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
		builder.append("matchId", matchId);
		builder.append("teamNameOne", teamNameOne);
		builder.append("teamNameTwo", teamNameTwo);
		builder.append("teamResultOne", teamResultOne);
		builder.append("teamResultTwo", teamResultTwo);
		builder.append("group", group);
		builder.append("kickOffDate", getKickOffDate());
		return builder.toString();
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Integer getUserBetGoalsTeamOne() {
		return userBetGoalsTeamOne;
	}

	public void setUserBetGoalsTeamOne(Integer userBetgoalsTeamOne) {
		this.userBetGoalsTeamOne = userBetgoalsTeamOne;
	}

	public Integer getUserBetGoalsTeamTwo() {
		return userBetGoalsTeamTwo;
	}

	public void setUserBetGoalsTeamTwo(Integer userBetGoalsTeamTwo) {
		this.userBetGoalsTeamTwo = userBetGoalsTeamTwo;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getKickOffDateString() {
		return kickOffDateString;
	}

	public void setKickOffDateString(String kickOffDateString) {
		this.kickOffDateString = kickOffDateString;
	}

	public String getKickOffTimeString() {
		return kickOffTimeString;
	}

	public void setKickOffTimeString(String kickOffTimeString) {
		this.kickOffTimeString = kickOffTimeString;
	}

}
