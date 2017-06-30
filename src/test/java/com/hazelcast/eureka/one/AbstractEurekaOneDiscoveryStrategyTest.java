package com.hazelcast.eureka.one;


import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.EurekaClient;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.Answers;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public abstract class AbstractEurekaOneDiscoveryStrategyTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    EurekaClient eurekaClient;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    ApplicationInfoManager applicationInfoManager;

    EurekaOneDiscoveryStrategy strategy;

    final String APPLICATION_NAME = "hazelcast-test";

    @Before
    public void setup() {
        when(applicationInfoManager.getInfo().getAppName()).thenReturn(APPLICATION_NAME);
        when(applicationInfoManager.getEurekaInstanceConfig().getAppname()).thenReturn(APPLICATION_NAME);

        initializeStrategy();
    }

    protected abstract void initializeStrategy();
}
