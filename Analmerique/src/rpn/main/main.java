package rpn.main;

class FirstApp {
	public static void main(String[] args) throws InterruptedException {
		MainProcess mainProcess = new MainProcess();
		MainUI mainUI = new MainUI();

		mainUI.start();
		Thread.sleep(1000);
		mainProcess.start();
		
			
	}
	
}