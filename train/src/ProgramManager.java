public class ProgramManager {
	public static TrainListManager trainListManager;
	public static void main(String[] args) throws InterruptedException {
		trainListManager = new TrainListManager();
		boolean isServerSolutionWanted = true;
		if (isServerSolutionWanted) {
			Server server = new Server(trainListManager);
			Thread serverThread = new Thread(server);
			serverThread.start();
		} else {
			for (int i = 0; i < 30; i++) {
				Operator op = new Operator(trainListManager);
				op.start();
				op.join();
			}
		}		
	}
}