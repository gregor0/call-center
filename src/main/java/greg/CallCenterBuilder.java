package greg;

public abstract class CallCenterBuilder {

	public final Dispatcher build() {
		DispatcherCompuesto callCenter = buildCallCenter();
		
		callCenter.add(buildOperadores());
		callCenter.add(buildSupervisores());
		callCenter.add(buildDirectores());
		
		return build(callCenter);
	}
	
	protected Dispatcher build(Dispatcher callCenter) {
		return callCenter;
	}
	
	protected abstract Dispatcher buildOperadores();

	protected abstract Dispatcher buildSupervisores();

	protected abstract Dispatcher buildDirectores();

	protected abstract DispatcherCompuesto buildCallCenter();

}
