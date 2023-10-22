package edu.hw2;

import edu.hw1.Task4;
import edu.hw2.Task4.GetCallingData;
import edu.hw2.Task4.Information;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class Task4Test {
    @Test
    public void GetCallingInfo_shouldReturnNameAndClassWhereMethodWasCalled(){
        Information information = GetCallingData.callingInfo();

        assertThat(information.nameOfClass()).isEqualTo(this.getClass().getName());
        assertThat(information.nameOfMethod()).isEqualTo("GetCallingInfo_shouldReturnNameAndClassWhereMethodWasCalled");
    }
}
