package streamy;

import org.hamcrest.Matcher;

import java.time.Duration;
import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * This example code comes from https://dzone.com/articles/a-java-8-streams-cookbook
 */
public class Winner {
  public static final List<Winner> tdfWinners = Arrays.asList(
      new Winner(2006, "Spain", "Óscar Pereiro", "Caisse d'Epargne–Illes Balears", 3657, Duration.parse("PT89H40M27S"), 8),
      new Winner(2007, "Spain", "Alberto Contador", "Discovery Channel", 3570, Duration.parse("PT91H00M26S"), 4),
      new Winner(2008, "Spain", "Carlos Sastre", "Team CSC", 3559, Duration.parse("PT87H52M52S"), 5),
      new Winner(2009, "Spain", "Alberto Contador", "Astana", 3459, Duration.parse("PT85H48M35S"), 7),
      new Winner(2010, "Luxembourg", "Andy Schleck", "Team Saxo Bank", 3642, Duration.parse("PT91H59M27S"), 12),
      new Winner(2011, "Australia", "Cadel Evans", "BMC Racing Team", 3430, Duration.parse("PT86H12M22S"), 2),
      new Winner(2012, "Great Britain", "Bradley Wiggins", "Team Sky", 3496, Duration.parse("PT87H34M47S"), 14),
      new Winner(2013, "Great Britain", "Chris Froome", "Team Sky", 3404, Duration.parse("PT83H56M20S"), 14),
      new Winner(2014, "Italy", "Vincenzo Nibali", "Astana", 3661, Duration.parse("PT89H59M06S"), 19),
      new Winner(2015, "Great Britain", "Chris Froome", "Team Sky", 3360, Duration.parse("PT84H46M14S"), 16),
      new Winner(2016, "Great Britain", "Chris Froome", "Team Sky", 3529, Duration.parse("PT89H04M48S"), 14));
  private int year;
  private String nationality;
  private String name;
  private String team;
  private int lengthKm;
  private Duration winningTime;
  private int stageWins;
  private int daysInYellow;

  public Winner(int year, String nationality, String name, String team, int lengthKm, Duration winningTime, int daysInYellow) {
    this.year = year;
    this.nationality = nationality;
    this.name = name;
    this.team = team;
    this.lengthKm = lengthKm;
    this.winningTime = winningTime;
    this.daysInYellow = daysInYellow;
  }

  public static void main(String args[]) {
    // Filter and Map -
    List<String> winnersOfToursLessThan3500km = null; //tdfWinners.stream()
    // cool streaming code here
    // Winners of Tours Less than 3500km - [Alberto Contador, Cadel Evans, Bradley Wiggins, Chris Froome, Chris Froome]
    System.out.println("Winners of Tours Less than 3500km - " + winnersOfToursLessThan3500km);
    assertThat(winnersOfToursLessThan3500km,
        contains("Alberto Contador", "Cadel Evans", "Bradley Wiggins", "Chris Froome", "Chris Froome"));

    List<String> winnersOfToursGreaterThan3500km = null; //tdfWinners.stream()
    // cool streaming code here
    // Winners of Tours Greater than 3500km - [Óscar Pereiro, Alberto Contador, Carlos Sastre, Andy Schleck, Vincenzo Nibali, Chris Froome]
    System.out.println("Winners of Tours Greater than 3500km - " + winnersOfToursGreaterThan3500km);
    assertThat(winnersOfToursGreaterThan3500km,
        contains("Óscar Pereiro", "Alberto Contador", "Carlos Sastre", "Andy Schleck", "Vincenzo Nibali", "Chris Froome"));

    // limit -
    List<Winner> winnerObjectsOfToursLessThan3500kmLimit2 = null; //tdfWinners.stream()
    // cool streaming code here
    // winnerObjectsOfToursLessThan3500kmLimit2 [Alberto Contador, Cadel Evans]
    System.out.println("winnerObjectsOfToursLessThan3500kmLimit2 " + winnerObjectsOfToursLessThan3500kmLimit2);
    assertThat(winnerObjectsOfToursLessThan3500kmLimit2,
        contains(
            hasProperty("name", equalTo("Alberto Contador")),
            hasProperty("name", equalTo("Cadel Evans"))
        ));

    List<String> firstTwoWinnersOfToursLessThan3500km = null; //tdfWinners.stream()
    // cool streaming code here
    assertThat(firstTwoWinnersOfToursLessThan3500km,
        contains("Alberto Contador", "Cadel Evans"));

    // filter by distinct
    List<String> distinctTDFWinners = null; //tdfWinners.stream()
    // cool streaming code here
    System.out.println("distinctTDFWinners - " + distinctTDFWinners);
    assertThat(distinctTDFWinners,
        hasSize(8));

    long numberOfDistinceWinners = 0; //tdfWinners.stream()
    // cool streaming code here
    // numberOfDistinceWinners - 8
    System.out.println("numberOfDistinceWinners - " + numberOfDistinceWinners);
    assertThat(numberOfDistinceWinners, equalTo(8L));

    // skip records
    List<Winner> skipFirst2Winners = null; //tdfWinners.stream()
    // cool streaming code here
    // skipEveryOtherTDFWinner - [Carlos Sastre, Alberto Contador, Andy Schleck, Cadel Evans, Bradley Wiggins, Chris Froome, Vincenzo Nibali, Chris Froome, Chris Froome]
    System.out.println("skipEveryOtherTDFWinner - " + skipFirst2Winners);
    assertThat(skipFirst2Winners,
        everyItem(not(in(Arrays.asList(tdfWinners.get(0), tdfWinners.get(1)))))
    );

    List<String> mapWinnerYearNamesToList = null; //tdfWinners.stream()
    // cool streaming code here
    // mapWinnerYearNamesToList [2006 - Óscar Pereiro, 2007 - Alberto Contador, 2008 - Carlos Sastre, 2009 - Alberto Contador, 2010 - Andy Schleck, 2011 - Cadel Evans, 2012 - Bradley Wiggins, 2013 - Chris Froome, 2014 - Vincenzo Nibali, 2015 - Chris Froome, 2016 - Chris Froome]
    System.out.println("mapWinnerYearNamesToList " + mapWinnerYearNamesToList);
    assertThat(mapWinnerYearNamesToList,
        contains(
            "2006 - Óscar Pereiro", "2007 - Alberto Contador", "2008 - Carlos Sastre", "2009 - Alberto Contador", "2010 - Andy Schleck", "2011 - Cadel Evans", "2012 - Bradley Wiggins", "2013 - Chris Froome", "2014 - Vincenzo Nibali", "2015 - Chris Froome", "2016 - Chris Froome"
    ));


    List<Integer> mapWinnerNameLengthToList = null; //tdfWinners.stream()
    // cool streaming code here
    // mapWinnerNameLengthToList [13, 16, 13, 16, 12, 11, 15, 12, 15, 12, 12]
    System.out.println("mapWinnerNameLengthToList " + mapWinnerNameLengthToList);
    assertThat(mapWinnerNameLengthToList,
        contains(13, 16, 13, 16, 12, 11, 15, 12, 15, 12, 12
    ));

    // matching - allMatch, noneMatch
    Optional<Winner> anyWinnerNamedWiggins = null; //tdfWinners.stream()
    // cool streaming code here
    // winner2012 - Bradley Wiggins
    System.out.println("winner2012 - " + anyWinnerNamedWiggins.get());
    assertThat(anyWinnerNamedWiggins.get().getName(), containsString("Wiggins"));

    Optional<Integer> firstWinnerOfYear2014 = null; //tdfWinners.stream()
    // cool streaming code here
    // winnerYear2014 - 2014
    System.out.println("winnerYear2014 - " + firstWinnerOfYear2014.get());
    assertThat(firstWinnerOfYear2014.get(), equalTo(2014));

    // reducing - 0 --> initial value
    int totalDistance = 0; //tdfWinners.stream()
    // cool streaming code here
    // totalDistance - 38767
    System.out.println("totalDistance - " + totalDistance);
    assertThat(totalDistance, equalTo(38767));

    Optional<Integer> shortestYear = null; //tdfWinners.stream()
    // cool streaming code here
    // shortestYear - 3360
    System.out.println("shortestYear - " + shortestYear.get());
    assertThat(shortestYear.get(), equalTo(3360));

    Optional<Integer> longestYear = null; //tdfWinners.stream()
    // cool streaming code here
    // longestYear - 3661
    System.out.println("longestYear - " + longestYear.get());
    assertThat(longestYear.get(), equalTo(3661));

    Optional<Winner> fastestAveSpeedOfWinner = null; //tdfWinners.stream()
    // cool streaming code here
    System.out.println("fastestTDF - " + fastestAveSpeedOfWinner.get());
    assertThat(fastestAveSpeedOfWinner.get().getAveSpeed(), closeTo(39, 0));

    // shorthand use mapToDouble
    OptionalDouble fastestTDF = null; //tdfWinners.stream()
    // cool streaming code here
    // fastestTDF - 39.0
    System.out.println("fastestTDF - " + fastestTDF.getAsDouble());
    assertThat(fastestTDF.getAsDouble(), closeTo(39, 0));

    // groupingby - make a map whose keys are names
    Map<String, List<Winner>> namesVsWinner = null; //tdfWinners.stream()
    // cool streaming code here
    // namesVsWinner - {Bradley Wiggins=[Bradley Wiggins], Carlos Sastre=[Carlos Sastre], Cadel Evans=[Cadel Evans], Óscar Pereiro=[Óscar Pereiro], Chris Froome=[Chris Froome, Chris Froome, Chris Froome], Andy Schleck=[Andy Schleck], Alberto Contador=[Alberto Contador, Alberto Contador], Vincenzo Nibali=[Vincenzo Nibali]}
    System.out.println("namesVsWinner - " + namesVsWinner);
    assertThat(namesVsWinner, allOf(
        hasEntry(equalTo("Bradley Wiggins"), hasSize(1)),
        hasEntry(equalTo("Chris Froome"), hasSize(3))
    ));

    // join strings
    String allTDFWinnersTeamsCSV = null; //tdfWinners.stream()
    // cool streaming code here
    // allTDFWinnersTeams Caisse d'Epargne–Illes Balears, Discovery Channel, Team CSC, Astana, Team Saxo Bank, BMC Racing Team, Team Sky, Team Sky, Astana, Team Sky, Team Sky
    System.out.println("allTDFWinnersTeams " + allTDFWinnersTeamsCSV);
    assertThat(allTDFWinnersTeamsCSV, equalTo("Caisse d'Epargne–Illes Balears, Discovery Channel, Team CSC, Astana, Team Saxo Bank, BMC Racing Team, Team Sky, Team Sky, Astana, Team Sky, Team Sky"));

    // grouping
    Map<String, List<Winner>> winnersByNationality = null; //tdfWinners.stream()
    // cool streaming code here
    // winnersByNationality - {Great Britain=[Bradley Wiggins, Chris Froome, Chris Froome, Chris Froome], Luxembourg=[Andy Schleck], Italy=[Vincenzo Nibali], Australia=[Cadel Evans], Spain=[Óscar Pereiro, Alberto Contador, Carlos Sastre, Alberto Contador]}
    System.out.println("winnersByNationality - " + winnersByNationality);
    assertThat(winnersByNationality, allOf(
        hasEntry(equalTo("Great Britain"), hasSize(4)),
        hasEntry(equalTo("Spain"), hasSize(4)),
        hasEntry(equalTo("Luxembourg"), hasSize(1)),
        hasEntry(equalTo("Italy"), hasSize(1)),
        hasEntry(equalTo("Australia"), hasSize(1)),
        hasEntry(equalTo("Luxembourg"), hasSize(1))
    ));

    Map<String, Long> winsByNationalityCounting = null; //tdfWinners.stream()
    // cool streaming code here
    // winsByNationalityCounting - {Great Britain=4, Luxembourg=1, Italy=1, Australia=1, Spain=4}
    System.out.println("winsByNationalityCounting - " + winsByNationalityCounting);
    assertThat(winsByNationalityCounting, allOf(
        hasEntry(equalTo("Great Britain"), equalTo(4l)),
        hasEntry(equalTo("Spain"), equalTo(4l)),
        hasEntry(equalTo("Italy"), equalTo(1l)),
        hasEntry(equalTo("Australia"), equalTo(1l)),
        hasEntry(equalTo("Luxembourg"), equalTo(1l))
    ));
  }

  public double getAveSpeed() {
    return (getLengthKm() / (getWinningTime().getSeconds() / 3600));
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public int getLengthKm() {
    return lengthKm;
  }

  public void setLengthKm(int lengthKm) {
    this.lengthKm = lengthKm;
  }

  public Duration getWinningTime() {
    return winningTime;
  }

  public void setWinningTime(Duration winningTime) {
    this.winningTime = winningTime;
  }

  public int getStageWins() {
    return stageWins;
  }

  public void setStageWins(int stageWins) {
    this.stageWins = stageWins;
  }

  public int getDaysInYellow() {
    return daysInYellow;
  }

  public void setDaysInYellow(int daysInYellow) {
    this.daysInYellow = daysInYellow;
  }

  @Override
  public String toString() {
    return name;
  }
}
