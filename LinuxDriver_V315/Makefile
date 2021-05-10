
KERNEL_VER:=$(shell uname -r)
KERNEL_DIR:=/lib/modules/$(KERNEL_VER)/build
INSTALL_DIR:=/lib/modules/$(KERNEL_VER)/pax_ttyPos

obj-m := pax_ttyPos.o


all:
	$(MAKE) modules -C $(KERNEL_DIR) SUBDIRS=$(shell pwd)

clean:
	$(RM) *.o *.ko *.mod.* .*.cmd *~
	$(RM) -r .tmp_versions
	$(RM) *.order *.symvers
install: all
	install -D -m 644 pax_ttyPos.ko $(INSTALL_DIR)/pax_ttyPos.ko
	/sbin/depmod -a
uninstall:
	modprobe -r pax_ttyPos ; echo -n
	$(RM) $(INSTALL_DIR)/pax_ttyPos.ko
	/sbin/depmod -a

