package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    public void testHotSwapFuncs() throws IOException {
        var agent = ByteBuddyAgent.install();
        var val = new AgentBuilder.Default().type(ElementMatchers.is(BaseSum.class))
            .transform(
                (builder, typeDescription, classLoader, module, protectionDomain) ->
                    builder.method(named("sum"))
                        .intercept(MethodDelegation.to(InterceptorSum.class))
            )
            .installOn(agent);

        try {
            new ByteBuddy()
                .redefine(BaseSum.class, ClassFileLocator.ForInstrumentation.fromInstalledAgent(BaseSum.class.getClassLoader()))
                .method(named("sum").and(ElementMatchers.returns(int.class)))
                .intercept(MethodDelegation.to(InterceptorSum.class))
                .make()
                .load(BaseSum.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

            assertThat(BaseSum.sum(4, 4)).isEqualTo(16);
        } finally {
            ClassReloadingStrategy.fromInstalledAgent().reset(BaseSum.class);
        }

        assertThat(BaseSum.sum(4, 4)).isEqualTo(8);
    }

    public class BaseSum {
        public static int sum(int x, int y) {
            return x + y;
        }
    }

    public class InterceptorSum {
        public static int sum(int x, int y) {
            return x * y;
        }
    }
}
