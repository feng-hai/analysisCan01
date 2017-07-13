package simplekafka08.simplekafka08;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	boolean zhangh = false;
		boolean mim = false;
		int[] zh = new int[10];
		int[] mm = new int[10];
		int[] zhangHaoBangDing = new int[10];
		Scanner in = new Scanner(System.in);
		System.out.println("欢迎使用本系统");
		while (true) {
			System.out
					.println("请选择功能\n1.登录\n2.注册\n3.忘记密码？密码找回\n4.帐号绑定\n5.退出系统\n6.！帐号注销，不建议");
			int num = in.nextInt();
			switch (num) {
			case 1:
				System.out.println("请输入帐号：注：必须是数字");
				int zhangHao = in.nextInt();
				for (int i = 0; i < zh.length; i++) {
					if (zh[i] == zhangHao) {
						zhangh = true;
						break;
					}
				}
				System.out.println("请输入密码：注：必须是数字");
				int miMa = in.nextInt();
				for (int i = 0; i < mm.length; i++) {
					if (mm[i] == miMa) {
						mim = true;
						break;
					}
				}
				if (zhangh == false) {
					System.out.println("！没有此帐号，请确定您是否注册");
				}
				break;
			case 2:
				boolean zhuCeZhangHao1 = false;
				boolean zhuCeMiMa1 = false;
				System.out.println("请输入您要注册的帐号！注：必须是数字");
				int zhuCeZhangHao = in.nextInt();
				for (int i = 0; i < zh.length; i++) {
					if (zh[i] == 0) {
						zh[i] = zhuCeZhangHao;
						zhuCeZhangHao1 = true;
						break;
					}
				}
				System.out.println("请输入你的密码：注：必须是数字");
				int zhuCeMiMa = in.nextInt();
				for (int i = 0; i < mm.length; i++) {
					if (mm[i] == 0) {
						mm[i] = zhuCeMiMa;
						zhuCeMiMa1 = true;
						break;
					}
				}
				if (zhuCeZhangHao1 == false || zhuCeMiMa1 == false) {
					System.out.println("帐号已满，后续将会改善，给您带来不便，sorry");
				} else if (zhuCeZhangHao1 == true && zhuCeMiMa1 == true) {
					System.out.println("注册成功");
				}
				break;
			case 3:
				boolean boole = false;
				System.out.println("请输入您的绑定号码");
				int zhaohui = in.nextInt();
				for (int i = 0; i < zhangHaoBangDing.length; i++) {
					if (zhangHaoBangDing[i] == zhaohui) {
						System.out.println("您的帐号：" + zh[i] + "\n您的密码：" + mm[i]
								+ "\n您的绑定号码：" + zhangHaoBangDing[i]
								+ "\n请牢记您的帐号密码和绑定帐号");
						boole = true;
					}
				}
				if (boole == false) {
					System.out.println("！没有此绑定号码，请重新找回密码，谢谢配合");
				}
				break;
			case 4:
				boolean boolea = false;
				System.out.println("请输入一个6位整数，注：绑定号码不可以“0”开头");
				int zhbd = in.nextInt();
				System.out.println("请输入您的帐号：");
				int z = in.nextInt();
				for (int i = 0; i < zh.length; i++) {
					if (zh[i] == z) {
						zhangHaoBangDing[i] = zhbd;
						boolea = true;
						break;
					}
				}
				if (boolea == false) {
					System.out.println("！没有此帐号，请注册");
				} else if (boolea == true) {
					System.out.println("绑定成功\n您的绑定号码，请记牢\n" + zhbd);
				}
				break;
			case 5:
				break;
			case 6:
				break;
			}
			while (true) {
				if (zhangh == true && mim == true) {
					zhangh = false;
					mim = false;
					System.out.println("登录成功");
					System.out.println("请选择功能\n1.常用功能\n2.计算机\n3.返回上一级");
					int i = in.nextInt();
					if (i == 1) {
						System.out.println("功能正在开发，见谅^_^");
						zhangh = true;
						mim = true;
					} else if (i == 2) {
						System.out.println("功能正在开发，见谅^_^");
						zhangh = true;
						mim = true;
					} else if (i == 3) {
						break;
					}
				} else {
					break;
				}
			}
			if (num == 5) {
				System.out
						.println("确定退出？退出后您的一切信息将不会被保存，包括注册信息，退出请输入“6”-_-\t随意数字回车继续执行本系统");
				int tuichu = in.nextInt();
				if (tuichu == 6) {
					break;
				}
			}
			if (num == 6) {
				System.out.println("确认注销-_-\t注销帐号请输入“7”随意数字回车后继续执行");
				int zhuxiao = in.nextInt();
				if (zhuxiao == 7) {
					boolean zhux = false;
					System.out.println("请输入您要注销的帐号：");
					int zx = in.nextInt();
					for (int i = 0; i < zh.length; i++) {
						if (zh[i] == zx) {
							zh[i] = 0;
							mm[i] = 0;
							zhux = true;
							break;
						}
					}
					if (zhux == false) {
						System.out.println("没有此帐号");
					} else if (zhux == true) {
						System.out.println("注销成功");
					}
				}
			}

		}
		System.out.println("已退出，欢迎下次使用^_^");
    }
}
