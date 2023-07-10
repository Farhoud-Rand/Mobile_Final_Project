package com.example.final_project.Models;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CustomCalendarView extends GridView {

    private List<Date> reservedDates;
    private List<Date> availableDates;
    private Calendar currentDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy", Locale.getDefault());
    private OnDateClickListener onDateClickListener;
    private Date selectedStartDate;
    private Date selectedEndDate;

    public CustomCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        reservedDates = new ArrayList<>();
        availableDates = new ArrayList<>();
        currentDate = Calendar.getInstance();
        setNumColumns(7);
        setGravity(Gravity.CENTER);
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Date clickedDate = (Date) parent.getItemAtPosition(position);
                if (onDateClickListener != null) {
                    onDateClickListener.onDateClick(clickedDate);
                    updateCalendar();
                }
            }
        });
        updateCalendar();
    }

    public void setReservedDates(List<Date> reservedDates) {
        this.reservedDates = reservedDates;
        updateCalendar();
    }

    public void setAvailableDates(List<Date> availableDates) {
        this.availableDates = availableDates;
        updateCalendar();
    }

    public void setOnDateClickListener(OnDateClickListener listener) {
        this.onDateClickListener = listener;
    }

    public void previousMonth() {
        currentDate.add(Calendar.MONTH, -1);
        updateCalendar();
    }

    public void nextMonth() {
        currentDate.add(Calendar.MONTH, 1);
        updateCalendar();
    }

    public void setSelectedDates(Date startDate, Date endDate) {
        selectedStartDate = startDate;
        selectedEndDate = endDate;
        updateCalendar();
    }

    private void updateCalendar() {
        List<Date> dates = getCalendarDates();
        setAdapter(new CalendarAdapter(getContext(), dates));
    }

    private List<Date> getCalendarDates() {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = (Calendar) currentDate.clone();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int previousMonthDays = (firstDayOfWeek - 1) % 7;

        calendar.add(Calendar.DAY_OF_MONTH, -previousMonthDays);
        while (dates.size() < 42) {
            dates.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dates;
    }

    private class CalendarAdapter extends BaseAdapter {

        private Context context;
        private List<Date> dates;

        CalendarAdapter(Context context, List<Date> dates) {
            this.context = context;
            this.dates = dates;
        }

        @Override
        public int getCount() {
            return dates.size();
        }

        @Override
        public Date getItem(int position) {
            return dates.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null) {
                textView = new TextView(context);
                textView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 120));
                textView.setPadding(5, 5, 5, 5);
            } else {
                textView = (TextView) convertView;
            }

            Date date = dates.get(position);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            textView.setText(String.valueOf(day));
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.BLACK);

            // Set background color based on reserved or available dates
            if (reservedDates.contains(date)) {
                textView.setBackgroundColor(Color.RED);
                textView.setTextColor(Color.WHITE);
            } else if (availableDates.contains(date)) {
                textView.setBackgroundColor(Color.GREEN);
                textView.setTextColor(Color.WHITE);
            } else {
                textView.setBackgroundColor(Color.TRANSPARENT);
            }

            // Set background color based on selected date range
            if (selectedStartDate != null && selectedEndDate != null) {
                if (date.equals(selectedStartDate) || date.equals(selectedEndDate)) {
                    textView.setBackgroundColor(Color.BLUE);
                    textView.setTextColor(Color.WHITE);
                } else if (date.after(selectedStartDate) && date.before(selectedEndDate)) {
                    textView.setBackgroundColor(Color.CYAN);
                    textView.setTextColor(Color.BLACK);
                }
            }

            return textView;
        }
    }

    public interface OnDateClickListener {
        void onDateClick(Date date);
    }
}
