SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "CLOSED"


inherit module

SRC_URI = "git://github.com/hajmedwissem/timotwofx_driver.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"



DEPENDS += "virtual/kernel"
S = "${WORKDIR}/git"


EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR} M=${S}"


do_compile() {
    
    oe_runmake KERNELDIR=${STAGING_KERNEL_DIR} M=${S} 

}

#KERNEL_MODULE_AUTOLOAD += "timotwofxdriver"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 timotwofxdriver.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/

}



INSANE_SKIP:timotwofxdriver-dbg = "buildpaths"