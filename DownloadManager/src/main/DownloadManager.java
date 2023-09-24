package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Entity.Download;

/**
 * Esta é a classe DownloadManager, na qual serve de exemplo de como Threads funcionam em java
 * @author Lucas Alexandre Bez Piancoski
 * @version 1.0
 */
public class DownloadManager {

	/**
	 * Inicia uma lista do tipo Download criando um array vazio
	 */
	private List<Download> downloads = new ArrayList<>();
	
	/**
	 * Instância de um objeto que implementa a interface ExecutorService
	 * que irá fornecer a fábrica newFixedThreadPool
	 */
	private ExecutorService executorService;

	/**
	 * Metodo cria um novo executor utilizando o newFixedThreadPool(Metodo mais recomendado)
	 * na qual se utiliza do parametro
	 * @param maxConcurrentDownloads
	 * para definir a quantidade de Threads que poderam ser executadas por vez
	 */
	public DownloadManager(int maxConcurrentDownloads) {
		executorService = Executors.newFixedThreadPool(maxConcurrentDownloads);
	}

	/**
	 * Adiciona o objeto download a lista downloads
	 * @param download
	 */
	public void adicionarDownload(Download download) {
		downloads.add(download);
	}

	/**
	 * Inicia as threads, ou seja, os downloads usando o multithreading
	 * 3 Threads ficam no Status RUNNABLE e 3 ficam em waiting 
	 * e quando uma das threads terminam(TERMINATED) o executor 
	 * seleciona uma das que estavam em WAITING automaticamente
	 */
	public void iniciarDownloads() {

		// Instancia random para gerar numeros aleatorios
		Random random = new Random();

		// Laço para pegar os objetos da lista donwloads 
		for (Download download : downloads) {
			
			/**
			 * Inicia a execução da tarefa em segundo plano em uma das threads gerenciadas pelo ExecutorService
			 * na qual é escolhido automaticamente pelo mesmo
			 */
			executorService.submit(() -> {
				try {
					/**
					 * Inicia a instancia
					 *  @param progress
					 *  para imprimir no console o progresso do download da thread
					 */
					int progress = 0;
 
					while (progress < 100) {
						/**
						 * Pega a thread atual, coloca no estado TIMED_WAITING atraves do sleep usando o random
						 * para gerar o tempo que ficara pausado, e quando finaliza volta ao estado RUNNABLE.
						 */
						Thread.sleep(random.nextLong(100, 600));
						// Adiciona o nome da thread atual atraves do nome do objeto download
						Thread.currentThread().setName(download.getName());
						// incrementa o progress em 1% (Simula o donwload)
						progress++;
						System.out.println("Downloading " + download.getName() + " Progress: " + progress + "%");
					}
					System.out.println("Download concluído: " + download.getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		
		// Imprime o status das threads enquanto estão em execução
		for (Thread thread : Thread.getAllStackTraces().keySet()) {
		    String threadName = thread.getName();
		    if (!threadName.equals("Finalizer") &&
		        !threadName.equals("Reference Handler") &&
		        !threadName.equals("Notification Thread") &&
		        !threadName.equals("Attach Listener") &&
		        !threadName.equals("main") &&
		        !threadName.equals("Signal Dispatcher") &&
		        !threadName.equals("Common-Cleaner")) {
		        System.out.println("Thread " + threadName + " Status: " + thread.getState());
		    }
		}

	}

	/**
	 * Este método encerra o ExecutorService de forma ordenada, o que significa que
	 * ele não aceitará mais tarefas novas, mas aguardará até que todas as tarefas
	 * existentes sejam concluídas. Se alguma tarefa estiver aguardando para ser executada,
	 * ela será executada antes do encerramento completo.
	 */
	public void esperarDownloadsConcluirem() {
		/**
		 * Encerra o ExecutorService de forma ordenada e aguarda até que todas as tarefas
		 * em andamento sejam concluídas ou um tempo limite seja atingido.
		 */
		executorService.shutdown();
		try {
			/**
			 * Encerra o ExecutorService de forma ordenada e aguarda até que todas as tarefas
			 * em andamento sejam concluídas ou um tempo limite seja atingido.
			 */
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			/**
			 * @throws InterruptedException se a thread atual for interrompida enquanto aguarda o término das tarefas.
			 */
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// chama o download manager enviando o limite
		DownloadManager manager = new DownloadManager(3);
		
		// chama o metodo pra adicionar na lista downloads um obejto download
		// Thread no estado NEW
		manager.adicionarDownload(new Download(1, "image.gif"));
		manager.adicionarDownload(new Download(2, "myMusic.mp3"));
		manager.adicionarDownload(new Download(3, "programa.exe"));
		manager.adicionarDownload(new Download(4, "programa2.exe"));
		manager.adicionarDownload(new Download(5, "image_cats.jpeg"));
		manager.adicionarDownload(new Download(6, "HelloMotoMusic.mp3"));

		// Inicia a threads
		manager.iniciarDownloads();
		manager.esperarDownloadsConcluirem();
		System.out.println("Todos os downloads foram concluídos.");
	}

}
