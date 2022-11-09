package trygeneric;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */
public interface ResultDataCreator<RETURN_TYPE> {

     List<RETURN_TYPE> createResult(SapGenericTableOutputData tableOutputData);
}
