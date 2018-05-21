package issue.jerboy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.litho.widget.Text;
import com.facebook.soloader.SoLoader;

public class MainActivity extends AppCompatActivity {

  RecyclerView recyclerView;
  FrameLayout container;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    SoLoader.init(this, false);
    setContentView(R.layout.activity_main);

    container = findViewById(R.id.lithocontainer);

    ComponentContext c = new ComponentContext(this);

    RecyclerBinder binder = new RecyclerBinder.Builder().build(c);
    binder.appendItem(Text.create(c).text("sssss").textSizeSp(20).backgroundColor(0xffff0000).build());


    LithoView lithoView = LithoView.create(c, Recycler
        .create(c)
        .binder(binder)
        .canMeasure(true)
        .flexGrow(0)
        .build());
    lithoView.setBackgroundColor(0xff00FF00);
    container.addView(lithoView, new LayoutParams(-1, -2));


  }
}
