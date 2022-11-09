package signifyapi;

/**
 * @author Nanda Kumar
 * @since 12/10/2022
 */
public class GetScheduleLineCapableProducts {

    private static final String JWT_TOKEN="eyJ0eXAiOiJKV1QiLCJraWQiOm51bGwsImFsZyI6IlJTMjU2In0.eyJpc3MiOiJNeUxpZ2h0aW5nIiwiZXhwIjoxNjY2MTc5MjgxLCJpYXQiOjE2NTc1MzkyODEsIm5iZiI6MTY1NzUzOTI4MSwic3ViIjoibmFuZGEua3VtYXIua2dAc2lnbmlmeS5jb20iLCJncm91cHMiOlsiTUxBLVVzZXJfQWRtaW4iLCJNTEYtT0VfUHJvZmlsZSIsIk1MRi1GaW5hbmNlX1Byb2ZpbGUiLCJNTC1Tb2xkVG8iLCJNTFQtSVRfVXNlciIsIk1MLU9FTS1EUCIsIk1MVC1BUElVc2VyIiwiTUxULUhDUF9EZXZlbG9wZXIiXSwibGFuZ3VhZ2UiOiJFTiIsImNvdW50cnkiOiJFUyIsImp0aSI6IjQyZTkwZDdhLWRkY2UtNDU0ZS04ODYxLWQ3MDBiMDI2Zjc4OCIsInVzZXJfbmFtZSI6Im5hbmRhLmt1bWFyLmtnQHNpZ25pZnkuY29tIn0.u0mcxsX5n-UYZRxSzrbzktGDP_-934r21-fWvzkOzEQeESj-7dPL8pUdi3x7-5ho5-VKRg4JFbzXMWLBbRCIOVC5eXuw0sJG6VZuZR3p9AgBTfsxRxtUSV7L0A2lKOxR0764vJ75XejKJTOxXvoF_mHmosOSYDDLr6jlh2lFKfljW1gSTA82QxfEnsWBCVBUxCqFT562uF0YOGwwbqsVmvYr7BsAcun0rsZXj4RLDsvrm3C_PMha_WQLVAZsyPx3yqIhihlItsnQZElouq7Tx9M8aEHLkwlpdk_O2CFOG2xdrPa0zOnO7HtrT3ph0SxTUqbgadedpAi7DdW4Xi6Bpw";

    public static void main(String[] args) {

        SearchHelper searchHelper=new SearchHelper(SearchHelper.ENV.TST,
                "0010021825_US01_02_01", "US01_02", JWT_TOKEN);

        searchHelper.getMaterial12NCList(null);
    }
}
