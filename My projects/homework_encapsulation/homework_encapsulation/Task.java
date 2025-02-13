package homework_encapsulation;

public class Task {
	
	private String taskName;
	private int workingHoursToFinishTheTask;
	
	//setter i getter za imeto
	public void setName(String name){
		
		if(name != null && !name.equals("")){
			
			this.taskName = name;
			
		}
	}
	
	public String getName(){
		
		return taskName;
		
	}
	//setter i getter za rabotnite chasove
	public void setWorkingHoursToFinishTheTask(int workingHours){
		
		if(workingHours >= 0){
			
			this.workingHoursToFinishTheTask = workingHours;
			
		}
	}

	public int getWorkingHoursToFinishTheTask(){
		
		return workingHoursToFinishTheTask;
		
	}
	
	//default konstruktor
	Task(){
		
		this.taskName = null;
		this.workingHoursToFinishTheTask = 0;
		
	}
	
	//konstruktur za task polzvasht setteri
	Task(String name, int workingHours){
		
		setName(name);
		setWorkingHoursToFinishTheTask(workingHours);
		
	}
	
}
