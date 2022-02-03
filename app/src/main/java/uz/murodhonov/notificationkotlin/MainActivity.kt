package uz.murodhonov.notificationkotlin

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import uz.murodhonov.notificationkotlin.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("UnspecifiedImmutableFlag", "RemoteViewLayout")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            val notificationCompat = NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Murodhonov UZ")
                .setContentText("This is an example of notification test")
                .setAutoCancel(true)

            val notification = notificationCompat.build()

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Name"
                val descriptionText = "Description"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("1", name, importance).apply {
                    description = descriptionText
                }
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(1, notification)
        }

        binding.btnShow2.setOnClickListener {

            val options = BitmapFactory.Options()
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img, options)

            val notificationCompat = NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Murodhonov UZ")
                .setContentText("This is an example of notification test")
                .setAutoCancel(true)
                .setLargeIcon(bitmap)

            val notification = notificationCompat.build()

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Name"
                val descriptionText = "Description"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("1", name, importance).apply {
                    description = descriptionText
                }
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(2, notification)
        }

        binding.btnShow3.setOnClickListener {

            val intent = Intent(this, NotificationActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val options = BitmapFactory.Options()
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img, options)

            val notificationCompat = NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Murodhonov UZ")
                .setContentText("This is an example of notification test")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setLargeIcon(bitmap)

            val notification = notificationCompat.build()

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Name"
                val descriptionText = "Description"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("1", name, importance).apply {
                    description = descriptionText
                }
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(3, notification)
        }

        binding.btnShow4.setOnClickListener {

            val intent = Intent(this, NotificationActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val options = BitmapFactory.Options()
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img, options)

            val max = 100

            val notificationCompat = NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Murodhonov UZ")
                .setContentText("This is an example of notification test")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setLargeIcon(bitmap)
                .setProgress(max,0,true)

            val notification = notificationCompat.build()

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Name"
                val descriptionText = "Description"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("1", name, importance).apply {
                    description = descriptionText
                }
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(4, notification)
        }

        binding.btnShow5.setOnClickListener {

            val intent = Intent(this, NotificationActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val options = BitmapFactory.Options()
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img, options)

            val max = 100

            val notificationCompat = NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Murodhonov UZ")
                .setContentText("This is an example of notification test")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setLargeIcon(bitmap)
                .setProgress(max,0,true)

            val notification = notificationCompat.build()

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Name"
                val descriptionText = "Description"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("1", name, importance).apply {
                    description = descriptionText
                }
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(5, notificationCompat.build())

            Thread(Runnable {
                Thread.sleep(2000)
                for (i in 0..max){
                    Thread.sleep(250)
                    notificationCompat.setProgress(max,i,false)
                        .setContentText("$i of $max")
                    notificationManager.notify(5,notificationCompat.build())
                }
            }).start()
        }

        binding.btnShow6.setOnClickListener{

            val messagingStyle = NotificationCompat.MessagingStyle("You")
            messagingStyle.setConversationTitle("Android chat")
                .addMessage("Hello",System.currentTimeMillis(),"Murodhonov")
                .addMessage("Hi",System.currentTimeMillis(),"Javohir")
                .addMessage("Привет",System.currentTimeMillis(),"Islomjon aka")
                .addMessage("Hello",System.currentTimeMillis(),"Murodhonov")
                .addMessage("Hi",System.currentTimeMillis(),"Javohir")
                .addMessage("Привет",System.currentTimeMillis(),"Islomjon aka")
                .addMessage("Hello",System.currentTimeMillis(),"Murodhonov")
                .addMessage("Hi",System.currentTimeMillis(),"Javohir")
                .addMessage("Привет",System.currentTimeMillis(),"Islomjon aka")
                .addMessage("Hello",System.currentTimeMillis(),"Murodhonov")
                .addMessage("Hi",System.currentTimeMillis(),"Javohir")
                .addMessage("Привет",System.currentTimeMillis(),"Islomjon aka")

            val notificationCompat = NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Murodhonov UZ")
                .setContentText("This is an example of notification test")
                .setAutoCancel(true)
                .setStyle(messagingStyle)

            val notification = notificationCompat.build()

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Name"
                val descriptionText = "Description"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("1", name, importance).apply {
                    description = descriptionText
                }
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(6, notification)
        }

        binding.btnCancel.setOnClickListener {
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.cancelAll()
        }

        binding.btnShow7.setOnClickListener {

            val intent = Intent(this,MyService::class.java).putExtra("key","Salom")
            val pendingIntent = PendingIntent.getService(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

            val notificationCompat = NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Murodhonov UZ")
                .setContentText("This is an example of notification test")
                .setAutoCancel(true)
                .addAction(android.R.drawable.ic_delete,"DELETE",pendingIntent)

            val notification = notificationCompat.build()

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Name"
                val descriptionText = "Description"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("1", name, importance).apply {
                    description = descriptionText
                }
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(7, notification)
        }

        binding.btnShow8.setOnClickListener {

            val intent = Intent(this,MyService::class.java)
            intent.putExtra("key","Hello")
            val pendingIntent = PendingIntent.getService(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

            val remoteView = RemoteViews(packageName,R.layout.custom_layout)
            remoteView.setTextViewText(R.id.time,SimpleDateFormat("hh:mm").format(Date()))
            remoteView.setOnClickPendingIntent(R.id.rootView,pendingIntent)

            val notificationCompat = NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Murodhonov UZ")
                .setContentText("This is an example of notification test")
                .setAutoCancel(true)
                .setContent(remoteView)

            val notification = notificationCompat.build()

            val notificationManager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Name"
                val descriptionText = "Description"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("1", name, importance).apply {
                    description = descriptionText
                }
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(1, notification)
        }
    }
}