package jp.ac.meijou.android.hannama;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.hannama.databinding.ActivityMainBinding;
import jp.ac.meijou.android.hannama.databinding.CategoryWidgetBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // カテゴリウィジェットのテキストを設定
        setupCategoryWidgets();
    }

    /**
     * カテゴリウィジェットのテキストを設定するメソッド
     */
    private void setupCategoryWidgets() {
        // 飲食店カテゴリのテキスト設定
        CategoryWidgetBinding foodCategoryBinding = binding.foodCategory;
        foodCategoryBinding.categoryTitle.setText("# 飲食店");

        // ホテルカテゴリのテキスト設定
        CategoryWidgetBinding hotelCategoryBinding = binding.hotelCategory;
        hotelCategoryBinding.categoryTitle.setText("# ホテル");

        // 観光地カテゴリのテキスト設定
        CategoryWidgetBinding sightseeingCategoryBinding = binding.sightseeingCategory;
        sightseeingCategoryBinding.categoryTitle.setText("# 観光地");
    }
}