package example;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

/** サービスを起動停止するクラス. */
public class ServiceLauncher implements Daemon {

  private static ServiceLauncher launcher;

  private App app;

  /** コンストラクタ. */
  public ServiceLauncher() {}

  /** サービス実行. */
  public void run() {
    app = new App();
    app.run();
  }

  /** サービス停止処理 */
  public void terminate() {
    app.stop();
  }

  /** Windowsサービス開始時にcommons Daemonからコールされる */
  public static void startService(String args) {
    launcher = new ServiceLauncher();
    launcher.run(); // サービス停止まで制御もどってこないはず
  }

  /**
   * Windowsサービス停止時にcommons Daemonからコールされる
   *
   * @param args
   */
  public static void stopService(String args) {
    if (launcher != null) {
      launcher.terminate();
    }
  }

  /** Linuxで使用した場合commons Daemonからコールされる 未実装 */
  @Override
  public void destroy() {
    // Ingore
  }

  /** Linuxで使用した場合commons Daemonからコールされる 未実装 */
  @Override
  public void init(DaemonContext arg0) throws DaemonInitException, Exception {
    // Ingore
  }

  /** Linuxで使用した場合commons Daemonからコールされる 未実装 */
  @Override
  public void start() throws Exception {
    // Ingore
  }

  /** Linuxで使用した場合commons Daemonからコールされる 未実装 */
  @Override
  public void stop() throws Exception {
    // Ingore
  }

  /**
   * メイン関数 Windowsサービス時には未使用
   *
   * @param args
   */
  public static void main(String[] args) {
    launcher = new ServiceLauncher();
    launcher.run();
    return;
  }
}
