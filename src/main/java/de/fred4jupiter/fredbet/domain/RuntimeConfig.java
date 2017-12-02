package de.fred4jupiter.fredbet.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * These properties are changable at runtime (via admin page).
 * 
 * @author michael
 *
 */
public class RuntimeConfig {

	private boolean enabledParentChildRanking;

	private boolean enableChangingUsername;

	private boolean showDemoDataNavigationEntry;

	/**
	 * Creates demo data with additional users and matches.
	 */
	private boolean createDemoData;

	/**
	 * Sum points per user for selected country that will be shown in points
	 * statistics.
	 */
	private Country favouriteCountry;

	/**
	 * Password used if the user password has been reset.
	 */
	@NotEmpty
	private String passwordForReset;

	public boolean isEnabledParentChildRanking() {
		return enabledParentChildRanking;
	}

	public void setEnabledParentChildRanking(boolean enabledParentChildRanking) {
		this.enabledParentChildRanking = enabledParentChildRanking;
	}

	public boolean isEnableChangingUsername() {
		return enableChangingUsername;
	}

	public void setEnableChangingUsername(boolean enableChangingUsername) {
		this.enableChangingUsername = enableChangingUsername;
	}

	public boolean isShowDemoDataNavigationEntry() {
		return showDemoDataNavigationEntry;
	}

	public void setShowDemoDataNavigationEntry(boolean showDemoDataNavigationEntry) {
		this.showDemoDataNavigationEntry = showDemoDataNavigationEntry;
	}

	public boolean isCreateDemoData() {
		return createDemoData;
	}

	public void setCreateDemoData(boolean createDemoData) {
		this.createDemoData = createDemoData;
	}

	public Country getFavouriteCountry() {
		return favouriteCountry;
	}

	public void setFavouriteCountry(Country favouriteCountry) {
		this.favouriteCountry = favouriteCountry;
	}

	public String getPasswordForReset() {
		return passwordForReset;
	}

	public void setPasswordForReset(String passwordForReset) {
		this.passwordForReset = passwordForReset;
	}

}
