package edu.hw2;

import edu.hw1.Task4;
import edu.hw2.Task4.GetCallingData;
import edu.hw2.Task4.Information;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class Task4Test {
    @Test
    public void GetCallingInfo_shouldReturnNameAndClassWhereMethodWasCalled(){
        Information information = GetCallingData.callingInfo(new Throwable());

        assertThat(information.nameOfClass()).isEqualTo(this.getClass().getName());
        assertThat(information.nameOfMethod()).isEqualTo("GetCallingInfo_shouldReturnNameAndClassWhereMethodWasCalled");
    }
}
