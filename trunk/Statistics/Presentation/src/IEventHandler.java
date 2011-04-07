
public interface IEventHandler 
{
	public void processExpectationAction();
	public void processVarianceAction();
	public void processThirdInitialMomentAction();
	public void processFourthInitialMomentAction();
	public void processThirdCentralMomentAction();
	public void processFourthCentralMomentAction();
	public void processSkewnessAction();
	public void processExcessAction();
	public void processClearAction();
	public void processParseArgumentAction();
}
