package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ControlledTest.class, DiamondTest.class, DirtTest.class, EnemyTest.class, ExitGateTest.class,
		GravityTest.class, HeroTest.class, StoneTest.class, WallTest.class })
public class AllTests {

}
