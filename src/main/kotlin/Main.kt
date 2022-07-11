import java.io.File
import java.net.ServerSocket

fun main() {
    println("fuck")
    val server = ServerSocket(9999);
    val serverSocket = server.accept()
    Thread {
        if(File("good.pcm").exists()){
            File("good.pcm").delete();
        }
        while (true) {
            try {
                val buffer = ByteArray(2000)
                val input =serverSocket.getInputStream()
                val byteSize = input.read(buffer)
                if (byteSize > 0) {
                    val bytes=buffer.copyOfRange(0,byteSize)
                    File("good.pcm").appendBytes(bytes);
                }else{
                    break;
                }
            } catch (e: Exception) {
                break;
            }

        }
        println("fuck2")

    }.start()
}