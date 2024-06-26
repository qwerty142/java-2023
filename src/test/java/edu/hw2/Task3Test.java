package edu.hw2;

import edu.hw2.Task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManagers.FaultyConnectionManager;
import edu.hw2.Task3.ConnectionTypes.FaultyConnection;
import edu.hw2.Task3.ConnectionTypes.StableConnection;
import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    public void TestDefault(){
        var success = new DefaultConnectionManager(2, 0).getConnection();
        var fault = new DefaultConnectionManager(1, 1).getConnection();

        assertThat(fault).isInstanceOf(FaultyConnection.class);
        assertThat(success).isInstanceOf(StableConnection.class);
    }

    @Test
    public void TestDefaultSituation() throws Exception {
        var p = new PopularCommandExecutor(new FaultyConnectionManager(1), 5);
        p.updatePackages();
        assertThat(p.workDone).isTrue();
    }
}
